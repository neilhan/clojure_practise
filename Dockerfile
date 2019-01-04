FROM ubuntu:bionic
MAINTAINER http://neilhan.ca

# Install the appropriate software
RUN apt-get -y update 
RUN apt-get install -y zsh apt-utils neovim net-tools
RUN apt-get install -y bash  ctags curl git python wget build-essential
RUN apt-get install -y build-essential cmake 
RUN apt-get install -y openssh-client tmux sudo
RUN apt-get install -y apt-transport-https ca-certificates curl software-properties-common
RUN apt-get install -y maven

# ------------------------------------
# clojure
# ------------------------------------
RUN apt-get install -y leiningen

# -------------------------------------------------------
# -------------------------------------------------------
# create user
# -------------------------------------------------------
ARG user=clojure
RUN useradd -ms /bin/bash clojure 
RUN mkdir -p /home/clojure
RUN usermod -aG sudo clojure
RUN echo "clojure:clojure" | chpasswd
RUN usermod -aG docker clojure

# --------------------------------------------------------
# for mac home directory
RUN ln -s /home /Users
RUN ln -s /bin/sed /usr/bin/sed

# -------------------------------------------------------
USER clojure
ENV HOME /home/clojure

CMD ["/usr/bin/zsh"]
