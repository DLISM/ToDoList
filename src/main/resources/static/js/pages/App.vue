<template>

  <div v-if="!profile">

    <router-view></router-view>
  </div>

  <div v-else>
    <router-view></router-view>
  </div>
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

</style>