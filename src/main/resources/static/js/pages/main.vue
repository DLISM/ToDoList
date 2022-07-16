<template>
  <v-container v-if="!profile">
    <h2>Добро пожаловать в приложения My Tasks</h2>
    <p>Вы здесь можите составить список задач и эффективно управля вашим временим!</p>
    <p>Для начало работы войдите в аккаунт
      или зарегистрируйтесь, если у вас нету аккаунта!
    </p>
    <p>
      <v-btn
          depressed
          color="primary"
          @click="login"
      >
        Войти
      </v-btn>
      <v-btn
          depressed
          color="primary"
          @click="registration"
      >
        Регистрация
      </v-btn>
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
    login(){
      this.$router.push('/login')
    },
    registration(){
      this.$router.push('/registration')
    }
  }
}
</script>

<style scoped>

</style>