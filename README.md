# 🗡️💥 hofund-example 💥🗡️

This project is used to demonstrate and test [**hofund**](https://github.com/logchange/hofund) - tool set to monitor 
applications, connections and discover current state of components of the system

### Overview

This project contains following modules:

- products
- cart
- payment

### Prometheus

- [products](http://localhost:18081/actuator/prometheus)
- [cart](http://localhost:18082/actuator/prometheus)
- [payment](http://localhost:18083/actuator/prometheus)

Nodes
```

sum(label_replace(label_replace(hofund_connection_status, "title", "$1", "target","(.+)"), "id", "$1", "title", "(.+)")) without (source, target, instance, job, type) or
sum(label_replace(label_replace(hofund_info_status, "title", "$1", "application_name","(.+)"), "subtitle", "$1", "application_version", "(.+)")) without (application_name, application_version, instance, job)

```

Edges
```
sum(label_replace(hofund_connection_status, "title", "$1", "target","(.+)")) without (source, target, instance, job, type)
```