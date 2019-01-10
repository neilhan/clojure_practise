# Clojure practise

The answers that I did for http://www.4clojure.com

To use the docker as a development env:
```bash
# to build the docker image
./docker_build.sh
# or to build a fresh docker image
./docker_build.sh new

# to start the docker container with a z-shell, which gives you lein clojure development env.
./docker_run.sh
# or to put any command that you want to run as parameters
./docker_run.sh ls /home/clojure

# to run a clojure file which has a -main defined:
lein run -m lein run -m ca.neilhan.clojure4.hello param1 param2 ...

# to run a clojure as script
lein exec src/my_app/core.clj param1 param2 ...

# to run any clj in REPL, in the docker container
lein repl
(load-file "your_file.clj")

```

The docker_run.sh and func.sh provide a docker container that will let you run GUI apps. 

```
docker_run.sh
lein repl
(load-file "src/ca/neilhan/clojure4/..???.clj")
```
