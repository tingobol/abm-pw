/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abmwar;

import beans.ProveedorFacadeLocal;
import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Label;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import controller.ProductoDAOLocal;
import entidades.Producto;
import entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.component.html.HtmlPanelGrid;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.event.TableSelectPhaseListener;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Productos.java
 * @version Created on 26-ago-2009, 6:13:31
 * @author liz
 */
public class Productos extends AbstractPageBean {

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
    private TextField txtFiltro = new TextField();

    public TextField getTxtFiltro() {
        return txtFiltro;
    }

    public void setTxtFiltro(TextField tf) {
        this.txtFiltro = tf;
    }
    private DropDown dropDownFiltro = new DropDown();

    public DropDown getDropDownFiltro() {
        return dropDownFiltro;
    }

    public void setDropDownFiltro(DropDown dd) {
        this.dropDownFiltro = dd;
    }
    private com.sun.webui.jsf.component.Button botonInsertar1 = new com.sun.webui.jsf.component.Button();

    public com.sun.webui.jsf.component.Button getbotonInsertar1() {
        return botonInsertar1;
    }

    public void setbotonInsertar1(com.sun.webui.jsf.component.Button b) {
        this.botonInsertar1 = b;
    }
    private HtmlPanelGrid gridPanelForm = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelForm() {
        return gridPanelForm;
    }

    public void setGridPanelForm(HtmlPanelGrid hpg) {
        this.gridPanelForm = hpg;
    }
    private HtmlPanelGrid gridPanelBotones = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBotones() {
        return gridPanelBotones;
    }

    public void setGridPanelBotones(HtmlPanelGrid hpg) {
        this.gridPanelBotones = hpg;
    }
    private Button btnAceptar = new Button();

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(Button b) {
        this.btnAceptar = b;
    }
    private HtmlPanelGrid gridPanelDown = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDown() {
        return gridPanelDown;
    }

    public void setGridPanelDown(HtmlPanelGrid hpg) {
        this.gridPanelDown = hpg;
    }
    private Button btnUpdate = new Button();

    public Button getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(Button b) {
        this.btnUpdate = b;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Productos() {
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
            log("Productos Initialization Failure", e);
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
        cargaFiltro();
        if (viewForm) {
            gridPanelForm.setRendered(true);
            gridPanelBotones.setRendered(true);
            if (updating) {
                btnAceptar.setRendered(false);
                
                try {
                    RowKey rowKey = tableRowGroup.getRowKey();
                    getListaProductos();
                    producto = listaProductos.get(Integer.parseInt(rowKey.getRowId()));
                    if (producto != null) {
                        txtCantidad.setText(producto.getCantidad().toString());
                        txtDescripcion.setText(producto.getDescripcion());
                        txtNombre.setText(producto.getNombre());
                        txtPrecio.setText(producto.getPrecio());
                        dropDownProveedor.setSelected(producto.getProveedor().getCodigo().toString());
                        System.out.println(producto.toString());
                        txtCantidad.setText(producto.getCantidad().toString());
                        txtDescripcion.setText(producto.getDescripcion());
                        txtNombre.setText(producto.getNombre());
                        txtPrecio.setText(producto.getPrecio());
                        dropDownProveedor.setSelected(producto.getProveedor().getCodigo().toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (inserting) {
                btnUpdate.setRendered(false);
            }
        } else {
            gridPanelForm.setRendered(false);
            gridPanelBotones.setRendered(false);
        }
    }
    private TableRowGroup tableRowGroup = new TableRowGroup();
    private TableSelectPhaseListener tablePhaseListener =
            new TableSelectPhaseListener();

    public TableSelectPhaseListener getTablePhaseListener() {
        return tablePhaseListener;
    }

    public void setTablePhaseListener(TableSelectPhaseListener tablePhaseListener) {
        this.tablePhaseListener = tablePhaseListener;
    }

    public void setSelected(Object object) {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    public Object getSelected() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);

    }

    public Object getSelectedValue() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;
    }

    public boolean getSelectedState() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    //AGREGADO
    private Label labelForbidden = new Label();

    public Label getLabelForbidden() {
        return labelForbidden;
    }

    public void setLabelForbidden(Label l) {
        this.labelForbidden = l;
    }
    private HtmlPanelGrid gridPanelContent = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelContent() {
        return gridPanelContent;
    }

    public void setGridPanelContent(HtmlPanelGrid hpg) {
        this.gridPanelContent = hpg;
    }
    //private List<Option> optionFiltro;
    // Inyectamos el EJB para tener acceso a los datos
    @EJB
    private ProductoDAOLocal productoDao;
    private Producto producto; // Mantenemos una entidad para manipularla
    private List<Producto> listaProductos; // Mantenemos una lista para mostrar los datos en pantalla
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

    public List<Producto> getListaProductos() {
        btnBuscar_action();
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    private List<Option> opcionFiltro;

    private void cargaFiltro() {
        opcionFiltro = new ArrayList<Option>();
        opcionFiltro.add(new Option("0", "Codigo"));
        opcionFiltro.add(new Option("1", "Nombre"));
        opcionFiltro.add(new Option("2", "Descripcion"));
    }

    public List<Option> getOpcionFiltro() {
        return opcionFiltro;
    }

    public void setOpcionFiltro(List<Option> opcionFiltro) {
        this.opcionFiltro = opcionFiltro;
    }

    public String btnBuscar_action() {
        String condicion = "";
        try {
            if (txtFiltro.getText() != null && txtFiltro.getText().toString().length() > 0) {
                String prefix = txtFiltro.getText().toString();
                if (dropDownFiltro.getSelected().toString().equals("0")) {
                    condicion = " where p.codigo = " + prefix;
                } else if (dropDownFiltro.getSelected().toString().equals("1")) {
                    condicion = " where upper(p.nombre) like '%" + prefix.toUpperCase() + "%'";
                } else {
                    condicion = " where upper(p.descripcion) like '%" + prefix.toUpperCase() + "%'";
                }
            }
            listaProductos = productoDao.getListaProductos(condicion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // envia al usuario a la ventana de modificacion de producto
    public String botonModificar_action() {
        viewForm = true;
        updating = true;

        return null;
    }

    // elimina un
    public String botonEliminar_action() {
        try {
            btnBuscar_action();
            RowKey rowKey = tableRowGroup.getRowKey();
            producto = listaProductos.get(Integer.parseInt(rowKey.getRowId()));
            productoDao.delete(producto);
            info("Registro eliminado con exito!");

        } catch (Exception e) {
            error("Error al eliminar el registro. " + e);
        }
        return null;
    }
    private Button botonInsertar = new Button();
    private Button botonModificar = new Button();
    private Button botonEliminar = new Button();
    private Boolean viewForm = false;
    private Boolean updating = false;
    private Boolean inserting = false;

    public Button getBotonInsertar() {
        return botonInsertar;
    }

    public void setBotonInsertar(Button botonInsertar) {
        this.botonInsertar = botonInsertar;
    }

    public Button getBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(Button botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    public Button getBotonModificar() {
        return botonModificar;
    }

    public void setBotonModificar(Button botonModificar) {
        this.botonModificar = botonModificar;
    }

    public TableRowGroup getTableRowGroup() {
        return tableRowGroup;
    }

    public void setTableRowGroup(TableRowGroup tableRowGroup) {
        this.tableRowGroup = tableRowGroup;
    }

//    public String botonAgregar1_action() {
//        return "producto_add";
//    }
    public String botonInsertar1_action() {
        viewForm = true;
        inserting = true;
        return null;
    }

    public String btnAceptar_action() {
        producto = new Producto();
        producto.setCantidad(Integer.parseInt(txtCantidad.getText().toString()));
        producto.setDescripcion(txtDescripcion.getText().toString());
        producto.setNombre(txtNombre.getText().toString());
        producto.setPrecio(Integer.parseInt(txtPrecio.getText().toString()));
        producto.setProveedor(proveedorFacade.find(dropDownProveedor.getSelected()));
        try {
            productoDao.insert(producto);
            viewForm = false;
            info("El registro se ha insertado con exito!");
        } catch (Exception e) {
            error("Ha ocurrido un error! " + e);
            e.printStackTrace();
        }
        return null;
    }

    public String btnUpdate_action() {
        producto = getSessionBean1().getProducto();
        producto.setCantidad(Integer.parseInt(txtCantidad.getText().toString()));
        producto.setDescripcion(txtDescripcion.getText().toString());
        producto.setNombre(txtNombre.getText().toString());
        producto.setPrecio(Integer.parseInt(txtPrecio.getText().toString()));
        producto.setProveedor(proveedorFacade.find(dropDownProveedor.getSelected()));
        try {
            productoDao.update(producto);
            viewForm = false;
            info("El registro se ha actualizado con exito!");
        } catch (Exception e) {
            error("Ha ocurrido un error! " + e);
            e.printStackTrace();
        }
        return null;
    }

    public String btnCancelar_action() {
        return null;
    }
}

