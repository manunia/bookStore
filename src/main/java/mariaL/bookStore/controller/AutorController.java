package mariaL.bookStore.controller;

import mariaL.bookStore.entity.Autor;
import mariaL.bookStore.repo.AutorRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("autor")
public class AutorController {

    private final AutorRepo autorRepo;

    public AutorController(AutorRepo autorRepo) {
        this.autorRepo = autorRepo;
    }
    //получение списка авторов
    @GetMapping
    public List<Autor> list() {
        return autorRepo.findAll();
    }
    //получение автора по id
    @GetMapping("{id}")
    public Autor getOne(@PathVariable("id") Autor autor) {
        return autor;
    }

    //добавление объекта
    @PostMapping
    public Autor create(@RequestBody Autor autor) {
        return autorRepo.save(autor);
    }

    //обновление
    @PutMapping("{id}")
    public Autor update(
            @PathVariable("id") Autor autorFromDb,
            @RequestBody Autor autor
    ) {
        BeanUtils.copyProperties(autor,autorFromDb,"id");

        return autorRepo.save(autorFromDb);
    }

    //удаление
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Autor autor) {
        autorRepo.delete(autor);
    }
}
