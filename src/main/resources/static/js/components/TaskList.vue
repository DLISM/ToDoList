<template>
<v-container>
  <div v-for="task in tasks">
   {{task.text}}
  </div>
</v-container>
</template>

<script>
import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)
const taskAPI=Vue.resource('/task')

export default {
  name: "TaskList",
  data(){
    return{
      tasks:''
      }

  },
  methods:{
    getTasks(){
      taskAPI.get().then(response => {
        this.tasks=response.body
      }, response => {
        console.log("error get")
      });
    }

  },
  created() {

    this.getTasks();
  }
}
</script>

<style scoped>

</style>