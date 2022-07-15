<template>
  <v-app>
    <v-toolbar
        color="cyan"
        dark
        flat
    >
      <v-toolbar-title>My Tasks</v-toolbar-title>
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
  }
}
</script>

<style>
h1{
  color:#fff
}
</style>