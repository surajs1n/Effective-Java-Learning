1. The easiest way to avoid problems is not to override the `equals` method, in which ease instance of the class is equal only to itself. This is the right thing to do if any of the following conditions apply:      
    - Each instance of the class is inherently unique.
    - There is no need for the class to provide a "logical equality" test.
    - A superclass has already over-ridden `equals`, and the superclass behaviour is appropriate for this class.
    - The class is private or package-private, and you are certain that its `equals` method will never be invoked. 
2. General contracts to adhere when to override `equals` method.
    - *Reflexive* : When `x != null`, then `x.equals(x)` must return `true`.
    - *Symmetric* : When `x,y != null` and `x.equals(y)` returns `true`, then `y.equals(x)` must return `true`.
    - *Transitive* : When `x,y,z != null` and `x.equals(y)` and `y.equals(z)` return `true`, then `x.equals(z)` must return `true`. 
    - *Consistent* : When `x,y != null`, then multiple invocations of `x.equals(y)` must consistently return `true` or `false`, provided no information used in `equals` comparisons is modified.
    - When `x != null`, then `x.equals(null)` must return `false`.
       