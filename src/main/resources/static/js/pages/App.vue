<template>
  <v-app>
    <v-toolbar
        color="cyan"
        dark
        dense
    >
      <v-toolbar-title>My Tasks</v-toolbar-title>
      <v-spacer></v-spacer>
      <router-link :to="{name:'profile'}" v-if="profile" class="link">{{profile.username}}</router-link>
      <router-link v-if="profile" to="/logout" class="link">Выход</router-link>
      <router-link v-else :to="{name:'login'}" class="link">Войти</router-link>
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

.btn{
  padding: 10px 30px;
  background: #e6e6e6;
  color: #fff;
  text-decoration: none;
}

.btn-primary{
  background: #007bff;
  color: #fff;
}

.btn-danger{
  color: #fff;
  background: #dc3545;
}

.link{
  text-decoration: none;
  color: #fff;
  margin: 0 15px;
}
</style>