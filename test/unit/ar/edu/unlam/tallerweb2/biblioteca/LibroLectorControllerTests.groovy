package ar.edu.unlam.tallerweb2.biblioteca



import org.junit.*
import grails.test.mixin.*

@TestFor(LibroLectorController)
@Mock(LibroLector)
class LibroLectorControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/libroLector/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.libroLectorInstanceList.size() == 0
        assert model.libroLectorInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.libroLectorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.libroLectorInstance != null
        assert view == '/libroLector/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/libroLector/show/1'
        assert controller.flash.message != null
        assert LibroLector.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/libroLector/list'

        populateValidParams(params)
        def libroLector = new LibroLector(params)

        assert libroLector.save() != null

        params.id = libroLector.id

        def model = controller.show()

        assert model.libroLectorInstance == libroLector
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/libroLector/list'

        populateValidParams(params)
        def libroLector = new LibroLector(params)

        assert libroLector.save() != null

        params.id = libroLector.id

        def model = controller.edit()

        assert model.libroLectorInstance == libroLector
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/libroLector/list'

        response.reset()

        populateValidParams(params)
        def libroLector = new LibroLector(params)

        assert libroLector.save() != null

        // test invalid parameters in update
        params.id = libroLector.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/libroLector/edit"
        assert model.libroLectorInstance != null

        libroLector.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/libroLector/show/$libroLector.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        libroLector.clearErrors()

        populateValidParams(params)
        params.id = libroLector.id
        params.version = -1
        controller.update()

        assert view == "/libroLector/edit"
        assert model.libroLectorInstance != null
        assert model.libroLectorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/libroLector/list'

        response.reset()

        populateValidParams(params)
        def libroLector = new LibroLector(params)

        assert libroLector.save() != null
        assert LibroLector.count() == 1

        params.id = libroLector.id

        controller.delete()

        assert LibroLector.count() == 0
        assert LibroLector.get(libroLector.id) == null
        assert response.redirectedUrl == '/libroLector/list'
    }
}
