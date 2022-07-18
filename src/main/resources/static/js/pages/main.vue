<template>
  <v-container v-if="!profile">
    <h2>Добро пожаловать в приложения My Tasks</h2>
    <p>Вы здесь можите составить список задач и эффективно управля вашим временим!</p>
    <p>Для начало работы войдите в аккаунт
      или зарегистрируйтесь, если у вас нету аккаунта!
    </p>
    <p>
      <router-link :to="{name:'login'}" class="btn btn-primary">Войти</router-link>
      <router-link :to="{name:'register'}" class="btn btn-primary">Регистрация</router-link>

    </p>
  </v-container>
  <v-container v-else>
    <task-list/>
  </v-container>
</template>

<script>
import TaskList from 'components/TaskList.vue'
export default {
  name: "main",
  components:{
    TaskList
  },
  data(){
    return{
      profile: frontendData
    }
  },
  methods:{

  }
}
</script>

<style scoped>

</style>