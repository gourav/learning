# Generic Spring Security Flow

![Authentication-Flow](/authentication-flow.png)

Here:
- AuthenticationFilter delegates authentication request to AuthenticationManager and based on response, configures the security context.
- AuthenticationManager uses one of the available AuthenticationProviders to process authentication request.
- AuthenticationProvider implements the login for authentication.
- A UserService implements users management functionality, which a AuthenticationProvider can use for implementing logic for authentication.
- A PasswordEncoder implements password management, which a AuthenticationProvider can use for verification of the password.
- SecurityContext keeps the AuthenticationData for subsequent requests.

# `UserDetailsService`

An object that implements a `UserDetailsService` interface is responsible for managing details about users. 

# `PasswordEncoder`

A `PasswordEncoder` has two responsibilties:
1. Encode (Encrypt, Hash) password
2. Verify that password matches with the provided one.

The simplest yet dumbest `PasswordEncoder` would store password in plain text.

# 'AuthenticationProvider`

`AuthenticationProvider` implements the authentication logic. An application can utilize multiple `AuthenticationProvider`.

# Default Configuration

Spring Security will lock down all requests and configure HTTPBasic Authentication for logic. It will also generate a UUID based password on server start up that users can use along with "user" username to authenticate.

In default configuration, Spring Security configures default credentials `user` and `UUID` based password in a `UserDetailsService` implementation which maintains these credentials in internal memory of the application.

So, as part of default configuration, Spring will configure a bean like 'Base64PasswordEncoder` to accept `Base64` encoded passwords.

Whenever we change default implementation of `UserDetailsService`, it is required that we update the implementation of `PasswordEncoder` as well.

A default implementation of `AuthenticationProvider` it uses default implementations of `UserDetailsService` and `PasswordEncoder`.
