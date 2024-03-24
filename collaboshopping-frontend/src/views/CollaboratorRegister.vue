<!-- Login.vue -->
<script>
// @ is an alias to /src
import '../plugins/vuetify.js'
import '../plugins/webfontloader.js'
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import {ref} from 'vue'
import {useField, useForm} from 'vee-validate'

export default {
  name: 'CollaboratorRegister',
  components: {
    MainHeader,
    MainFooter
  }
}
</script>
<script setup>


import api from "@/plugins/axios.js";
import {TOKEN_KEY} from "../../common/variable.js";

const {handleSubmit, handleReset} = useForm({})
const address = useField('address')
const name = useField('name')
const checkbox = useField('checkbox')

const submit = handleSubmit(values => {
  //alert(JSON.stringify(values, null, 2))
  api.post("/api/v1/collaborators/apply", JSON.stringify(values, null, 2), {
    headers: {
      "Content-Type": `application/json`,
    },
  }).then((res) => {
    console.log("---axios Post 성공---- ");



  }).catch(error => {
    console.log(error.response);
    if (error.response.data.code === "MEMBER-ERR-C002" || error.response.data.code === "MEMBER-ERR-C003") {
      console.log("계정정보가 잘못되었습니다.");
    }
    alert("오류로 등록에 실패했습니다.");
  });
})
</script>

<template>
  <MainHeader/>
  <div style="width:50%;">
    <form @submit.prevent="submit">

      <v-text-field
          v-model="address.value.value"
          label="지역"
      ></v-text-field>

      <v-text-field
          v-model="name.value.value"
          label="이름"
      ></v-text-field>


      <v-checkbox
          v-model="checkbox.value.value"
          label="동의"
          type="checkbox"
          value="1"
      ></v-checkbox>

      <v-btn
          class="me-4"
          type="submit"
      >
        submit
      </v-btn>

      <v-btn @click="handleReset">
        clear
      </v-btn>
    </form>
  </div>

</template>