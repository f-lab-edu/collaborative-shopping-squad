<!-- Home.vue -->
<script>
// @ is an alias to /src
import '../plugins/vuetify.js'
import '../plugins/webfontloader.js'
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";

export default {
  name: 'NotFound',
  components: {
    MainHeader,
    MainFooter
  }
}
</script>

<template>
  <MainHeader/>

</template>