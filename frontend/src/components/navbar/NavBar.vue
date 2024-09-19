<script setup lang="ts">
import { RouterLink, RouterView, useRoute, useRouter } from "vue-router"
import NavBarall from "./NavBarAll.vue"
import NavBarAssets from "./NavBarAssets.vue"
import NavBarFin from "./NavBarFin.vue"
import NavBarStock from "./NavBarStock.vue"
</script>

<template>
  <div
    class="w-full max-w-[393px] fixed bg-white bottom-0 h-16 grid grid-cols-4 border rounded-t-lg border-black border-solid divide-x-2"
  >
    <NavBarAssets />
    <NavBarFin />
    <NavBarStock />
    <NavBarall />
  </div>
</template>
