1. Memory leaks in garbage-collected language (more properly known as unintentional object retentions) are insidious. 
2. Nulling out references should be the exception rather than the norm.
3. The programmer should effectively communicate this fact to the garbage collector by manually nulling out array elements as soon as they become part of the inactive portion.