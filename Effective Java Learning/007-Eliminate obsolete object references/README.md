1. Memory leaks in garbage-collected language (more properly known as unintentional object retentions) are insidious. 
2. Nulling out references should be the exception rather than the norm.
3. The programmer should effectively communicate this fact to the garbage collector by manually nulling out array elements as soon as they become part of the inactive portion.
4. Contradictory explanation : [Do not attempt to help the garbage collector by setting local reference variables to null](https://wiki.sei.cmu.edu/confluence/display/java/OBJ54-J.+Do+not+attempt+to+help+the+garbage+collector+by+setting+local+reference+variables+to+null). Just-in-time compilers can do equivalent analysis but programmer has to manually null out any un-used memory location.
