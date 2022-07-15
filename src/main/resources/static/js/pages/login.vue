<template>
  <v-container>
    <form th:action="@{/login}" method="post">
      <div><label> User Name : <input type="text" name="username"/> </label></div>
      <div><label> Password: <input type="password" name="password"/> </label></div>
      <div><input type="submit" value="Sign In"/></div>
    </form>
  </v-container>

</template>

<script>
export default {
  name: "login"
}
</script>

<style scoped>

</style>