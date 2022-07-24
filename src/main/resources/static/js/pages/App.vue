<template>
  <v-app>
    <topbar/>
    <router-view></router-view>
  </v-app>
</template>

<script>
import Topbar from 'components/Topbar.vue'
export default {
  name: "App",
  components:{
    Topbar
  },
  data(){
  },
  methods:{
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


</style>