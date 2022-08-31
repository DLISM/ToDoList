<template>
  <v-container>
    <h1 class="heading">Для входа в приложения введите пароль и логин</h1>
    <form action="/login" method="post">
      <div><label>Логин:</label> <br> <input type="text" name="username"/></div>
      <div><label>Пароль:</label> <br> <input type="password" name="password"/> </div>
      <div><input type="submit" value="Вход"/></div>
    </form>
  </v-container>

</template>

<script>
export default {
  name: "login"
}
</script>

<style scoped>
input{
  border: solid 1px #ccc;
  padding: 5px;
  width: 300px;
  margin-bottom: 20px;
}
input[type='submit']{
  background: #007bff;
  color: #fff;
  width: 150px;
}
.heading{
  color: #1f1f1f;
}
</style>