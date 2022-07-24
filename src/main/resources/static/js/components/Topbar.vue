<template>

  <v-toolbar
      color="cyan"
      dark
      dense
  >
    <v-toolbar-title>My Tasks</v-toolbar-title>
    <v-spacer></v-spacer>

    <template v-if="profile">

      <router-link :to="{name:'main'}" v-if="$route.path!='/'" class="link">
        Список задач
        <v-icon>
          mdi-calendar-check
        </v-icon>
      </router-link>

      <router-link :to="{name:'profile'}"  class="link">
        {{profile.username}}
        <v-icon>mdi-account</v-icon>
      </router-link>
      <router-link  to="/logout" class="link">
        <v-icon>mdi-logout</v-icon>
        Выйти
      </router-link>
    </template>

    <template v-else>
      <router-link  :to="{name:'login'}" class="link">
        Войти
      </router-link>
    </template>


  </v-toolbar>
</template>

<script>
export default {
  name: "Topbar",
  data(){
    return{
      profile: frontendData,
    }
  }
}
</script>

<style scoped>
.link{
  text-decoration: none;
  color: #fff;
  margin: 0 15px;
  cusor:pointer;
}
</style>