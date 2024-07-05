
<!-- TradeRegiser.vue -->
<script>
// @ is an alias to /src
import '../plugins/vuetify.js'
import '../plugins/webfontloader.js'
import MainHeader from "@/components/MainHeader.vue";
import MainFooter from "@/components/MainFooter.vue";
import {ref} from 'vue'
import {useField, useForm} from 'vee-validate'

export default {
  name: 'TradeRegister',
  components: {
    MainHeader,
    MainFooter
  }
}
</script>
<script setup>


import api from "@/plugins/axios.js";
import {TOKEN_KEY} from "../../common/variable.js";

const {handleSubmit, handleReset} = useForm({
  validationSchema: {
    title(value) {
      if (value?.length >= 1) return true

      return '거래글 제목을 작성해주세요.'
    },
    perPrice(value) {
      if (value?.length >= 1 && /[0-9-]+/.test(value)) return true

      return '금액을 입력해주세요.'
    },
    minPurchaseCount(value) {
      if (value?.length >= 1 && /[0-9-]+/.test(value)) return true

      return '수량을 입력해주세요.'
    },
    content(value) {
      if (value?.length >= 1) return true

      return '내용을 작성해주세요.'
    },
    checkbox(value) {
      if (value === '1') return true

      return 'Must be checked.'
    },
  },
})
const title = useField('title')
const content = useField('content')
const perPrice = useField('perPrice')
const minPurchaseCount = useField('minPurchaseCount')
const originUrl = useField('originUrl')

const checkbox = useField('checkbox')

const submit = handleSubmit(values => {
  //alert(JSON.stringify(values, null, 2))
  api.post("/api/v1/trades/register", JSON.stringify(values, null, 2), {
    headers: {
      "Content-Type": `application/json`,
    },
  }).then((res) => {
    console.log("---axios Post 성공---- ");



  }).catch(error => {
    console.log(error.response);
    alert(error.response.data.code);
  });
})
</script>

<template>
  <MainHeader/>
  <div style="width:50%;">
    <form @submit.prevent="submit">

      <v-text-field
          v-model="title.value.value"
          :error-messages="title.errorMessage.value"
          label="제목"
      ></v-text-field>

      <v-text-field
          v-model="originUrl.value.value"
          label="URL"
      ></v-text-field>

      <v-text-field
          v-model="perPrice.value.value"
          :error-messages="perPrice.errorMessage.value"
          label="단위가격"
      ></v-text-field>

      <v-text-field
          v-model="minPurchaseCount.value.value"
          :error-messages="minPurchaseCount.errorMessage.value"
          label="최소주문수량"
      ></v-text-field>

      <v-textarea
          v-model="content.value.value"
          :error-messages="content.errorMessage.value"
          label="상품안내"
      ></v-textarea>


      <v-checkbox
          v-model="checkbox.value.value"
          label="공동구매 등록 확인"
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