<template>
  <v-container>
  <h2>Регистрация</h2>
  <form action="/registration" method="post">
    <div>
      <label>Имя пользователья : </label>
      <input type="text" name="username"/>
    </div>
    <div>
      <label>Пароль:</label>
      <input type="password" name="password"/>
    </div>
    <div>
      <label>Потверждения пароля:</label>
      <input type="password" name="password2"/>
    </div>
    <div>
      <label>E-mail:</label>
      <input type="email" name="email"/>
    </div>
    <div><input type="submit" value="Зарегистрироваться"/></div>
  </form>
  </v-container>
</template>

<script>
export default {
  name: "registration"
}
</script>

<style scoped>

</style>