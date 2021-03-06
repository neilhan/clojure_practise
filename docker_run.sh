#!/bin/bash

export DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

run_cmd=$@

if [ $# -eq 0 ]
  then
    run_cmd=zsh
fi

DOCKER_USER=clojure

if [ "$(uname)" == "Darwin" ]; then
    # func.sh sets varables. Expecting docker_cmd, docker_common_options_mac or docker_common_options 
    source $DIR/func.sh
    # docker_cmd=nvidia-docker, or docker
    # set_xhost_ip is provided by func.sh
    set_xhost_ip
    $docker_cmd run --rm -it \
        --name d_clojure \
        -v /tmp:/tmp \
        -v /var/run/docker.sock:/var/run/docker.sock \
        -u=$UID:$(id -g $USER) \
        -v $HOME/.ssh:/home/$DOCKER_USER/.ssh \
        -v $HOME/.zshrc:/home/$DOCKER_USER/.zshrc \
        -v $HOME/.sharedrc:/home/$DOCKER_USER/.sharedrc \
        -v $HOME/.m2:/home/$DOCKER_USER/.m2 \
        -v $HOME/Projects:/home/$DOCKER_USER/Projects \
        -v $HOME:/Users/$USER \
        $docker_common_options_mac \
        d_clojure $run_cmd

else
# elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
    # func.sh sets varables. Expecting docker_cmd, docker_common_options_mac or docker_common_options 
    source $DIR/func.sh
    # docker_cmd=nvidia-docker, or docker
    # set_xhost_ip is provided by func.sh
    $docker_cmd run --rm -it \
        --name d_clojure \
        --net=host \
        -v /tmp:/tmp \
        -v /var/run/docker.sock:/var/run/docker.sock \
        -u=$UID:$(id -g $USER) \
        -v $HOME/.ssh:/home/$DOCKER_USER/.ssh \
        -v $HOME/.zshrc:/home/$DOCKER_USER/.zshrc \
        -v $HOME/.sharedrc:/home/$DOCKER_USER/.sharedrc \
        -v $HOME/.m2:/home/$DOCKER_USER/.m2 \
        -v $HOME/Projects:/home/$DOCKER_USER/Projects \
        -v $HOME:/home/$USER \
        $docker_common_options \
        d_clojure $run_cmd
fi

