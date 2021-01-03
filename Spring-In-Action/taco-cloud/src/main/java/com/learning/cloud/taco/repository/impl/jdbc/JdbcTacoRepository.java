package com.learning.cloud.taco.repository.impl.jdbc;

import com.learning.cloud.taco.domain.Ingredient;
import com.learning.cloud.taco.domain.Taco;
import com.learning.cloud.taco.repository.TacoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

public class JdbcTacoRepository implements TacoRepository {

    private static final String INSERT_INTO_TACO = "insert into Taco( name, createdAt ) values ( ?, ? ) ";
    private static final String INSERT_INTO_TACO_INGREDIENT = "insert into Taco_Ingredients( taco, ingredient ) values( ?, ? )";

    private final JdbcTemplate template;

    public JdbcTacoRepository( JdbcTemplate template ) {
        this.template = template;
    }

    @Override
    public Taco save(Taco taco) {

        long tacoId = saveTacoBasicDetails( taco );
        taco.getIngredients().forEach( ingredient -> this.saveTacoIngredients( ingredient, tacoId ));

        taco.setId( tacoId );
        return taco;

    }

    private long saveTacoBasicDetails( Taco taco ) {

        taco.setCreatedAt( new Date() );
        PreparedStatementCreatorFactory insertForTacoFactory = new PreparedStatementCreatorFactory( INSERT_INTO_TACO, Types.VARCHAR, Types.TIMESTAMP );
        insertForTacoFactory.setReturnGeneratedKeys( true );

        PreparedStatementCreator insertForTaco = insertForTacoFactory.newPreparedStatementCreator(Arrays.asList( taco.getName(), new Timestamp( taco.getCreatedAt().getTime() )));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.template.update( insertForTaco, keyHolder );

        return keyHolder.getKey().longValue();

    }

    private void saveTacoIngredients( Ingredient ingredient, long tacoId ) {

        PreparedStatementCreator insertForTacoIngredient = new PreparedStatementCreatorFactory( INSERT_INTO_TACO_INGREDIENT, Types.BIGINT, Types.VARCHAR )
                .newPreparedStatementCreator( Arrays.asList( tacoId, ingredient.getId() ));

        this.template.update( insertForTacoIngredient );

    }
}
