<template>
  <v-container>
    <v-card>
      <v-card-text>
        Логин: {{profile.username}}
      </v-card-text>
      <v-card-text>
        Email: {{profile.email}}
      </v-card-text>
    </v-card>

    <v-card class="mt-4 mb-4 pb-3" v-if="editProfile">
      <v-card-title>Изменить логин и email</v-card-title>
      <form @submit.prevent="saveProfile" class="px-4">
        <v-text-field
            v-model="username"
            label="Логин"
            required
        ></v-text-field>
        <v-text-field
            v-model="email"
            label="E-mail"
            required
        ></v-text-field>

        <v-btn type="submit" dark color="green">
          Сохранить
        </v-btn>
      </form>
    </v-card>

    <v-card class="mt-4 mb-4 pb-3" v-if="editPassword">
      <v-card-title>Изменить пароль</v-card-title>
      <form @submit.prevent="savePassword" class="px-4">
        <v-text-field
            v-model="newPassword"
            label="Пароль"
            required
        ></v-text-field>
        <v-text-field
            v-model="newPasswordConfirmed"
            label="Подтверждения паролья"
            required
        ></v-text-field>

        <v-btn type="submit" dark color="green">
          Сохранить
        </v-btn>
      </form>
    </v-card>

    <v-btn color="green" dark @click="editProfile = !editProfile">Редактировать профиль</v-btn>
    <v-btn @click="editPassword = !editPassword">Изменить пароль</v-btn>
  </v-container>
</template>

<script>
import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource)
const profileAPI=Vue.resource('/profile')
const passwordAPI=Vue.resource('/profile/update-password')

export default {
  name: "profile",

  data() {
    return {
      profile: frontendData,
      username: '',
      email: '',
      editProfile: false,
      editPassword: false,
      newPassword: '',
      newPasswordConfirmed: ''

    }
  },
  methods: {
    saveProfile() {
      var user = {username: this.username, email: this.email}

      profileAPI.update({}, user).then(response => {
        this.profile.username = response.body.username
        this.profile.email = response.body.email

        this.editProfile = false
      }, response => {
        console.log("error get")
      });
    }
    ,

    savePassword() {
      var user = {newPassword: this.newPassword, newPasswordConfirmed: this.newPasswordConfirmed}

      passwordAPI.update({}, user).then(response => {
        console.log(response)
        this.editPassword = false
      }, response => {
        console.log("error get")
      });
    }

  }
}
</script>

<style scoped>

</style>