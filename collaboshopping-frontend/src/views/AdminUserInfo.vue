
<!-- AdminUserInfo.vue -->
<script>
// @ is an alias to /src
import '../plugins/vuetify.js'
import '../plugins/webfontloader.js'
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import {ref} from 'vue'
import {useField, useForm} from 'vee-validate'
import {TOKEN_KEY} from "../../common/variable.js";
import router from "@/router/index.js";
import api from "@/plugins/axios.js";

export default {
  name: 'AdminUserInfo',
  components: {
    MainHeader,
    MainFooter
  },mounted() {
    this.loadFn();
  },methods: {
    loadFn() {
      /*let loginYn = localStorage.getItem(TOKEN_KEY);
      if (!(loginYn != null && typeof loginYn !== 'object')) {
        router.replace({path: '/'});
      }*/

      api.get("/api/v1/admins/getMembersList", JSON.stringify(null, null, 2), {}).then((res) => {
        this.list = res.data;
        console.log("list" + res.data);
      }).catch((error) => {
        console.log(error.response);
        alert(error.response.data.code);
      })
    },showRowInfo (event, { item } ) {
      console.log(item)
      this.editedIndex = this.list.indexOf(item)
      this.editedItem = Object.assign({}, item)

      console.log(this.editedIndex)
      console.log(this.editedItem)

      router.push('userDetail/'+this.editedItem.id);
    },
  },data() {
    return {
      list: [],
      search: '',
    }
  }
}
</script>
<script setup>

</script>

<template>
  <MainHeader/>
  <h1>회원정보관리</h1>
  <v-data-table
      :items="list"
      :search="search"
      @dblclick:row=showRowInfo>
  </v-data-table>



</template>