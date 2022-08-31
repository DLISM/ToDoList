<template>
  <v-container>
  <h2>Регистрация</h2>
    <form>
      <v-text-field
          v-model="username"
          :counter="10"
          label="Логин"
          required
      ></v-text-field>
      <v-text-field
          v-model="password"
          :counter="10"
          label="Пароль"
          required
      ></v-text-field>
      <v-text-field
          v-model="passwordConfirm"
          :counter="10"
          label="Подтверждения пароля"
          required
      ></v-text-field>
      <v-text-field
          v-model="email"
          label="E-mail"
          required
      ></v-text-field>
      <v-btn
          class="mr-4"
          @click="registration"
          dark
          color="green"
      >
        Зарегистрироваться
      </v-btn>

    </form>
  </v-container>
</template>

<script>
import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)
const regAPI=Vue.resource('/registration')

export default {
  name: "registration",
  data(){
    return{
      username:'',
      password:'',
      passwordConfirm:'',
      email:''
    }
  },
  methods:{
    registration(){
      var user={username: this.username, password: this.password, passwordConfirm: this.passwordConfirm, email: this.email}

      regAPI.save({}, user).then(() => {
        this.$router.push({name:'login'})
      }, response => {
        console.log("error get")
      });
    }
  }
}
</script>

<style scoped>
input{
  border:solid 1px #ccc;
}
</style>