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
      >
        Войти
      </v-btn>
      <v-btn
          depressed
          color="primary"
      >
        Регистрация
      </v-btn>
    </p>
  </v-container>
  <v-container v-else>
    List Task
  </v-container>
</template>

<script>
export default {
  name: "main",
  data(){
    return{
      profile: frontendData
    }
  }
}
</script>

<style scoped>

</style>