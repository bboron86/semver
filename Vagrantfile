# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|

  config.vm.define "bb-server" do |host|

    host.vm.box = "ubuntu/trusty64"
    host.vm.hostname = "bb-server"
    host.vm.network "private_network", ip: "192.168.33.100"

    host.vm.provider "virtualbox" do |v|
      if ENV['BB_SERVER']
        v.memory = 2048
      else
        v.memory = 2048
      end

      v.cpus = 2
    end

    # RabbitMQ Ports
    host.vm.network "forwarded_port", guest: 15672, host: 15672
    host.vm.network "forwarded_port", guest: 5672, host: 5672

    # Mongo Ports
    host.vm.network "forwarded_port", guest: 27017, host: 27017

    # Consul Ports
    host.vm.network "forwarded_port", guest: 8300, host: 8300
    host.vm.network "forwarded_port", guest: 8301, host: 8301
    host.vm.network "forwarded_port", guest: 8302, host: 8302
    host.vm.network "forwarded_port", guest: 8301, host: 8301, protocol: "udp"
    host.vm.network "forwarded_port", guest: 8302, host: 8302, protocol: "udp"
    host.vm.network "forwarded_port", guest: 8400, host: 8400
    host.vm.network "forwarded_port", guest: 8500, host: 8500
    host.vm.network "forwarded_port", guest: 53, host: 53, protocol: "udp"

    # Ports for services started on server
    (8181..8189).each do |i|
      host.vm.network "forwarded_port", guest: i, host: i
    end

    # Default Provision once
    host.vm.provision "shell", path: "bin/vagrant/provision_server.sh"

    #dynamically set environment variables
    host.vm.provision "shell", inline: "echo \"source /home/vagrant/variables\" >>/home/vagrant/.profile"
    host.vm.provision "shell", run: "always", inline: "echo \"\" >/home/vagrant/variables"
    if ENV['BB_SERVER']
      bbserver = ENV['BB_SERVER']
      host.vm.provision "shell", run: "always", inline: "echo \"export BB_SERVER=#{bbserver}\" >>/home/vagrant/variables"
      host.vm.provision "shell", run: "always", inline: "echo \"export SERVICE_IP=#{bbserver}\" >>/home/vagrant/variables"
    end
  end

  require 'etc'
  username = Etc.getlogin

  require 'socket'
  myIp = UDPSocket.open {|s| s.connect("8.8.8.8", 1); s.addr.last}

  puts "My IP: #{myIp}"
  if ENV['BB_SERVER']
    puts "Overriding BB_SERVER: #{ENV['BB_SERVER']}"
  end



end
