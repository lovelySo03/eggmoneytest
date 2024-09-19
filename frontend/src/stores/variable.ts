import { ref, computed } from "vue"
import { defineStore } from "pinia"

export const useVariableStore = defineStore("variable", () => {
  const title = ref("홈")
  const setTitle = (newTitle: string) => {
    title.value = newTitle
  }

  return { title, setTitle }
})
