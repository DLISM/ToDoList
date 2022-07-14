<template>
  <div>
    <form action="/login" method="post">
      <div><label> Пользователь : <input type="text" name="username"/> </label></div>
      <div><label> Пароль: <input type="password" name="password"/> </label></div>
      <div><input type="submit" value="Войти"/></div>
    </form>
  </div>

</template>

<script>
export default {
  name: "login"
}
</script>

<style scoped>

</style>