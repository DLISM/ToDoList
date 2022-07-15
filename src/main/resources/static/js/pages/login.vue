<template>
  <v-container>
    <v-content class="col-sm-4">
        <form>
          <v-text-field
              v-model="username"
              :error-messages="nameErrors"
              :counter="10"
              label="Логин"
              required
          ></v-text-field>
          <v-text-field
              v-model="password"
              :error-messages="emailErrors"
              label="Пароль"
              required
          ></v-text-field>
          <v-btn
              class="mr-4"
              @click="submit"
              color="primary"
          >
            Войты
          </v-btn>
        </form>
    </v-content>
  </v-container>

</template>

<script>
export default {
  name: "login"
}
</script>

<style scoped>

</style>