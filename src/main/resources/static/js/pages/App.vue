<template>

  <div v-if="!profile">
    <h1>Добро пожаловать в приложения My</h1>
    <p>Вы здесь можите составить список задач и эффективно управля вашим временим!</p>
    <p>Для начало работы войдите в аккаунт <br>
      или регестрируйтес, если у вас нету аккаунта
    </p>
    <p>
      <a href="/login">Войти</a>
      <a href="/registration">Регистрация</a>
    </p>
  </div>

  <div v-else>
    <router-view></router-view>
  </div>
</template>

<script>
import LoginPage from "pages/login.vue"
import Registration from "pages/registration.vue"

export default {
  name: "App",

  components:{
    LoginPage,
    Registration
  },

  data(){
    return{
      profile: frontendData
    }
  }
}
</script>

<style>

</style>