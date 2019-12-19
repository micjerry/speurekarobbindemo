验证Spring Service Eureka Robbin的方案

service-registry-center作为服务注册中心;

service-producer-demo作为服务生产者，注册服务供其它业务消费

service-consumer-demo作为服务消费者，去注册中心获取服务使用
   
   
验证：
   
    (1) 执行service-registry-center
   
    (2) 执行service-producer-demo，启动两个实例，一个端口号8080，一个端口号8090
   
    (3) 执行curl http://localhost:9002/loadbalancer/test 验证通过Spring LoadBalancer来访问producer
        执行curl http://localhost:9002/robbin/test 验证通过Spring Cloud Robbin来访问producer
       
   
 
