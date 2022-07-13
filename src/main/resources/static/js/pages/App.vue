<template>

  <div v-if="true">
    <h1>Welcome to My Tasks application!</h1>
    <p>You can create to do list and spend effectively your time!</p>
    <p>For start please <a href="/login">login</a></p>
  </div>

  <div v-else>
    <login-page/>
  </div>

</template>

<script>
import LoginPage from "pages/login.vue"
export default {
  name: "App",
  components:{
    LoginPage
  },
  date(){
    return{
    }
  }
}
</script>

<style>

</style>