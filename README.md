# word counter

I used following technologies: 
  - Spark 2.0.0
  - Java 1.8
  - Spring 4.3 (in __add_spring__ branch)


To run it:
1) Download Spark https://spark.apache.org/downloads.html
2) Run a master node 
```sh
$ ./sbin/start-master.sh
```
3) Run a worker 
```sh
$ ./bin/spark-class org.apache.spark.deploy.worker.Worker  spark://{see log of `start-master.sh` for host:port} -c 1 -m 512M
```
4) Run the programm:
```sh
$ ./bin/spark-submit   --class by.epam.rudenkov.WordCount   --master local[4]   WordCounter-1.0-SNAPSHOT.jar {yourRootForRecursiveAnalyze} {yourOutPutDir} 
```

Out put example:
```sh
(80983,)
(7908,public)
(7004,import)
(6672,string)
(4964,return)
(4433,com)
(4298,new)
(4250,final)
```
It tooks 10 seconds to process 1394 files assuming I have single master node. 

Inspired by https://www.youtube.com/watch?v=5OWqAjBBDBA 
