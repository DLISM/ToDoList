<template>
  <v-app>
    <v-toolbar
        color="cyan"
        dark
        dense
    >
      <v-toolbar-title>My Tasks</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn v-if="profile" icon href="/logout">
        Выход
      </v-btn>
      <v-btn v-else icon @click="login">
        Войти
      </v-btn>
    </v-toolbar>

      <router-view></router-view>

  </v-app>
</template>

<script>

export default {
  name: "App",

  data(){
    return{
      profile: frontendData
    }
  },
  methods:{
    login(){
      this.$router.push('/login')
    },
  }
}
</script>

<style>
h1{
  color:#fff
}
</style>