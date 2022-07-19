<template>
<v-container>
  <v-form v-model="valid">
    <v-text-field
      v-model="taskInput"
      :rules="taskRules"
      :counter="5"
      label="Task"
      required
    >
    </v-text-field>
    <v-btn @click='addTask' :disabled="!valid">Создать</v-btn>
  </v-form>

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
      tasks:'',
      taskInput:'',
      valid:false,
      taskRules: [
        v => !!v || 'Заполните поле!',
        v => v.length >= 5 || 'Задача должна быть более 5 символов',
      ],
      }

  },
  methods:{
    getTasks(){
      taskAPI.get().then(response => {
        this.tasks=response.body
      }, response => {
        console.log("error get")
      });
    },
    addTask(){
      taskAPI.save({}, {text:this.taskInput}).then(response => {
        this.tasks.push(response.body)
        this.taskInput=''
      }, response => {
        console.log("error get", response)
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