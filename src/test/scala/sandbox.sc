val l=List(10,6,1,7,8,2,4,5,11)
val (l1,r1)=l.partition(_<10)
l1.partition(_<l1.head)