def tasks = [:]

tasks["vagrant-1"] = {
  node('vagrant-slave') {  
    stage concurrency: 1, name: 'vagrant-slave-1'
    sh 'echo $NODE_NAME' 
  }
}
tasks["vagrant-2"] = {
  node('vagrant-slave-2') { 
    stage concurrency: 2, name: 'vagrant-slave-2'
    sh 'echo $NODE_NAME' 
  }
}

parallel tasks
