/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abmwar;

import beans.ProveedorFacadeLocal;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.TextField;
import controller.ProductoDAOLocal;
import entidades.Producto;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version ProductoForm.java
 * @version Created on Aug 26, 2009, 11:37:53 AM
 * @author markos
 */
public class ProductoForm extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private TextField txtNombre = new TextField();

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(TextField tf) {
        this.txtNombre = tf;
    }
    private TextField txtDescripcion = new TextField();

    public TextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(TextField tf) {
        this.txtDescripcion = tf;
    }
    private TextField txtCantidad = new TextField();

    public TextField getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(TextField tf) {
        this.txtCantidad = tf;
    }
    private TextField txtPrecio = new TextField();

    public TextField getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(TextField tf) {
        this.txtPrecio = tf;
    }
    private DropDown dropDownProveedor = new DropDown();

    public DropDown getDropDownProveedor() {
        return dropDownProveedor;
    }

    public void setDropDownProveedor(DropDown dd) {
        this.dropDownProveedor = dd;
    }
    private Button btnAceptar = new Button();

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(Button b) {
        this.btnAceptar = b;
    }
    private Button btnUpdate = new Button();

    public Button getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(Button b) {
        this.btnUpdate = b;
    }
    private Button btnCancelar = new Button();

    public Button getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(Button b) {
        this.btnCancelar = b;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public ProductoForm() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ProductoForm Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        if (getSessionBean1().getProducto() == null) {
            this.producto = new Producto();
            btnUpdate.setRendered(false);
        } else {
            this.producto = getSessionBean1().getProducto();
            btnAceptar.setRendered(false);
        }
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }
    private Producto producto;
    @EJB
    private ProductoDAOLocal productoDao;
    @EJB
    private ProveedorFacadeLocal proveedorFacade;
    private List<Proveedor> listaProveedores;
    private List<Option> listaProveedoresOption;

    public List<Option> getListaProveedoresOption() {
        listaProveedoresOption = new ArrayList<Option>();
        try {
            listaProveedores = proveedorFacade.findAll();
            if (listaProveedores != null) {
                for (Proveedor proveedor : listaProveedores) {
                    listaProveedoresOption.add(new Option(proveedor.getCodigo().toString(), proveedor.getNombre()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaProveedoresOption;
    }

    public void setListaProveedoresOption(List<Option> listaProveedoresOption) {
        this.listaProveedoresOption = listaProveedoresOption;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String btnAceptar_action() {
        String retorno = "failed";
        producto = new Producto();
        producto.setCantidad(Integer.parseInt(txtCantidad.getText().toString()));
        producto.setDescripcion(txtDescripcion.getText().toString());
        producto.setNombre(txtNombre.getText().toString());
        producto.setPrecio(Integer.parseInt(txtPrecio.getText().toString()));
        producto.setProveedor(proveedorFacade.find(dropDownProveedor.getSelected()));
        try {
            productoDao.insert(producto);
            retorno = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public String btnUpdate_action() {
        String retorno = "failed";
        producto = getSessionBean1().getProducto();
        producto.setCantidad(Integer.parseInt(txtCantidad.getText().toString()));
        producto.setDescripcion(txtDescripcion.getText().toString());
        producto.setNombre(txtNombre.getText().toString());
        producto.setPrecio(Integer.parseInt(txtPrecio.getText().toString()));
        producto.setProveedor(proveedorFacade.find(dropDownProveedor.getSelected()));
        try {
            productoDao.update(producto);
            retorno = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    public String btnCancelar_action() {
        return "volver";
    }

    public void dropDownProveedor_processValueChange(ValueChangeEvent vce) {
    }
}

