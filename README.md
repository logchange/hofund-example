# 🗡️💥 hofund-example 💥🗡️

This project is used to demonstrate and test [**hofund**](https://github.com/logchange/hofund) - tool set to monitor 
applications, connections and discover current state of components of the system



### Overview

This project contains following modules:

- products
- cart
- payment
- stats

### Grafana Credentials

- [Grafana](http://localhost:3000)

- Login: admin
- Password: foobar

### Prometheus

- [products](http://localhost:18081/actuator/prometheus)
- [cart](http://localhost:18082/actuator/prometheus)
- [payment](http://localhost:18083/actuator/prometheus)
- [stats](http://localhost:18084/actuator/prometheus)


Nodes
```

sum(label_replace(label_replace(hofund_connection_status, "title", "$1", "target","(.+)"), "id", "$1", "title", "(.+)")) without (source, target, instance, job, type) or
sum(label_replace(label_replace(hofund_info_status, "title", "$1", "application_name","(.+)"), "subtitle", "$1", "application_version", "(.+)")) without (application_name, application_version, instance, job)

```

Edges
```
sum(label_replace(hofund_connection_status, "title", "$1", "target","(.+)")) without (source, target, instance, job, type)
```

nodes from last 7 days:
```text
sum(0 * sum_over_time(hofund_node[7d])) by (id, title, subtitle, type)
```

% of time when node was up
```text
sum(avg_over_time(( sum without() (hofund_info) or (0 * sum_over_time(hofund_info[7d])) )[7d:5m])) by (id)
```

Current state of nodes:
```text
sum(sum without() (hofund_info) or (0 * sum_over_time(hofund_info[7d]))) by (id)
```

Some interesting query for nodes with mainstat
```txt
(sum(0 * sum_over_time(hofund_node[7d])) by (id, title, subtitle, type)) * on (id) group_left(mainstat) (count_values without() ("mainstat", sum(avg_over_time(( sum without() (hofund_info) or (0 * sum_over_time(hofund_info[7d])) )[7d:5m])) by (id)))
```


And one more
```

      (sum by (id, title, subtitle, type) (0 * sum_over_time(hofund_node[1w])))
    * on (id) group_left (mainstat)
      (
        count_values without () (
          "mainstat",
          sum by (id) (sum by (id) (sum without () (hofund_info) or (0 * sum_over_time(hofund_info[1w]))))
        )
      )
  * on (id) group_left (secondarystat)
    (
      count_values without () (
        "secondarystat",
        round(
          avg_over_time((sum without () (hofund_info) or (0 * sum_over_time(hofund_info[1w])))[1w:5m]),
          0.001
        )
      )
    )
or on (id)
  (sum by (id, title, subtitle, type) (0 * sum_over_time(hofund_node[1w])))

```


final nodes query??
```
      (sum by (id, title, subtitle, type) (0 * sum_over_time(hofund_node[1w])))
    * on (id) group_left (mainstat)
      (
        count_values without () (
          "mainstat",
          sum by (id) (sum by (id) (sum without () (hofund_info) or (0 * sum_over_time(hofund_info[1w]))))
        )
      )
  * on (id) group_left (secondarystat)
    (
      count_values without () (
        "secondarystat",
        round(avg_over_time((sum without () (hofund_info) or (0 * sum_over_time(hofund_info[1w])))[1w:5m]), 0.001)
      )
    )
  * on (id) group_left (arc__up)
      (
        count_values without () (
          "arc__up",
          sum by (id) (sum by (id) (sum without () (hofund_info) or (0 * sum_over_time(hofund_info[1w])))) * 0.999999
        )
      )
  * on (id) group_left (arc__down)
      (
        count_values without () (
          "arc__down",
          abs(sum by (id) (sum by (id) (sum without () (hofund_info) or (0 * sum_over_time(hofund_info[1w])))) - 1) * 0.999999
        )
      )
or on (id)
  (sum by (id, title, subtitle, type) (0 * sum_over_time(hofund_node[1w])) * on (id) group_left (arc__notfound)
      (
        count_values without () (
          "arc__notfound", (0 * sum_over_time(hofund_node[1w]) + 1) * 0.999999
        )
      ))
```
