<template>
<v-container>
  <v-form v-model="valid">
    <v-text-field
      v-model="taskInput"
      :rules="taskRules"
      :counter="5"
      label="Задача"
      required
    >
    </v-text-field>
    <v-btn @click='addTask' :disabled="!valid">Создать</v-btn>
  </v-form>

  <div v-for="task in tasks">

    <div v-bind:class="{ done: task.done }" class="task-item">
      <span>{{task.text}}</span>

      <div class="buttons">
        <div @click="deleteTask(task.id)">
          Удалить
          <v-icon>
            mdi-delete-circle-outline
          </v-icon>
        </div>

        <div @click="checkTask(task.id, task.done)">
          <span v-if="task.done">
            не сделан
            <v-icon >
              mdi-check-circle
            </v-icon>
          </span>
          <span v-else>
            Сделан
            <v-icon>
              mdi-checkbox-blank-circle-outline
            </v-icon>
          </span>
        </div>

      </div>

    </div>

  </div>

</v-container>
</template>

<script>
import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)
const taskAPI=Vue.resource('/task{/id}')

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
        console.log("error save", response)
      });
    },
    checkTask(idTask, status){

      taskAPI.update({id:idTask}, {done:!status}).then(response => {
        let elementIndex = this.tasks.findIndex((obj => obj.id == response.body.id));
        this.tasks[elementIndex].done=response.body.done

      }, response => {
        console.log("error update", response)
      });
    },

    deleteTask(idTask){
      taskAPI.delete({id:idTask}).then(response => {
        this.getTasks()
      }, response => {
        console.log("error update", response)
      });
    }

  },
  created() {
    this.getTasks();
  }
}
</script>

<style scoped>
.task-item{
  padding: 10px 5px;
  border-bottom: solid 1px #e6e6e6;
  display: flex;
  justify-content: space-between;
}
.done span{
  text-decoration: line-through;
}
.buttons{
  display: flex;
}
.buttons>div{
  margin: 0 20px;
}
</style>