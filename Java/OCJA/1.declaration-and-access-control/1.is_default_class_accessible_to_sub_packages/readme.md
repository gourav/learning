Question
--------
Can we access a default class from its subpackages ?

Answer
------
No. Each package is considered different. That means a, a.b and a.b.c are different packages that simply share common prefixes in their package names but it does not establishes anything.

Answer is no. A default isn't accessible from sub-packages.
