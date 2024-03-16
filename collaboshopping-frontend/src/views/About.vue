<!-- About.vue -->
<script>
import api from "../plugins/axios.js";

export default {
  data() {
    return {data: "null",};
  }, methods: {
    onClickGetData() {
      api.get("/member",{}).then((res) => {
        console.log("---axios Get 성공---- ");
        this.data = res.data;
        console.log(res.data);
      }).catch((res) => {
        console.error(res);
      });
    },
  },
};
</script>

<template>
  <div class="about">
    <h1>This is an about page</h1>
    <button @click="onClickGetData">click me</button>
  </div>
</template>