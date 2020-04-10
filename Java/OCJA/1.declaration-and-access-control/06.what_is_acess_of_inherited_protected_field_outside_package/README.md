Question
--------
Once a subclass outside of parent class, has inherited a protected member. After this, a non-sub class in same package as sub-class, is it able to access protected member ?

Answer
------
No. Non-subclasses aren't able to access the inherited protected member. Only subclasses of the subclasss can access it. For non-sub classes, that inherited `protected` member is as good as `private` member.
