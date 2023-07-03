import { ref } from './vue.global.min'

    const activeIndex = ref('1')
    const handleSelect = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
