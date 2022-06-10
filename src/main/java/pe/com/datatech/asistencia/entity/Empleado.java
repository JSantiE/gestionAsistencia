package pe.com.datatech.asistencia.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Empleado")
public class Empleado {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdEmpleado")
	private Integer idEmpleado;

	@Column(name = "IdEmpresa")
	private Integer idEmpresa;

	@Column(name = "CodigoMarcacion")
	private String codigoMarcacion;

	@Column(name = "ApellidoPaterno")
	private String apePaterno;

	@Column(name = "ApellidoMaterno")
	private String apeMaterno;

	@Column(name = "Nombres")
	private String nombres;

	@Column(name = "IdTipoDocIdentidad")
	private String idTipoDoc;

	@Column(name = "NroDocIdentidad")
	private String nroDocumento;

	@Column(name = "Email")
	private String email;

	@Column(name = "Direccion")
	private String direccion;

	@Column(name = "Telefono")
	private String telefono;

	@Column(name = "Sexo")
	private String sexo;

	@Column(name = "FlagActivo")
	private String estado;

	@Past
	@Column(name = "FechaNacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaNacimiento;

	@Past
	@Column(name = "FechaIngreso")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaIngreso;

	@Column(name = "IdUsuarioCreacion")
	private Integer idUsuarioCreacion;

	@Past
	@Column(name = "FechaCreacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaCreacion;

	@Column(name = "IdUsuarioModificacion")
	private Integer idUsuarioModificacion;

	@Past
	@Column(name = "FechaModificacion")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaModificacion;

	@Column(name = "IdArea")
	private Integer idArea;
	
	public Empleado() {
	}

	public Empleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCodigoMarcacion() {
		return codigoMarcacion;
	}

	public void setCodigoMarcacion(String codigoMarcacion) {
		this.codigoMarcacion = codigoMarcacion;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(String idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getIdUsuarioCreacion() {
		return idUsuarioCreacion;
	}

	public void setIdUsuarioCreacion(Integer idUsuarioCreacion) {
		this.idUsuarioCreacion = idUsuarioCreacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(Integer idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
}
