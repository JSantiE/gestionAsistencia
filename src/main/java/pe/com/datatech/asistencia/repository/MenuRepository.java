package pe.com.datatech.asistencia.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import pe.com.datatech.asistencia.dto.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
@CacheConfig(cacheNames = { "menues" })
public class MenuRepository {

	@Autowired
	private DataSource dataSource;

	private NamedParameterJdbcTemplate jdbcTemplate;

	@PostConstruct
	private void postConstruct() {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	}

	@Cacheable
	public List<Menu> getMenues(int idEmpresa, int idUsuario) throws DataAccessException {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("UsuarioMenu_List")
				.returningResultSet("menus", new MenuMapper());
		SqlParameterSource in = new MapSqlParameterSource().addValue("IdEmpresa", idEmpresa).addValue("IdUsuario",
				idUsuario);
		Map<String, Object> results = jdbcCall.execute(in);
		@SuppressWarnings("unchecked")
		List<Menu> menus = (List<Menu>) results.get("menus");
		return menus;
	}

	private static class MenuMapper implements RowMapper<Menu> {
		@Override
		public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
			Menu menu = new Menu();
			menu.setIdMenu(rs.getInt("IdMenu"));
			menu.setCodMenu(rs.getString("CodMenu"));
			menu.setIdMenuPadre(rs.getInt("IdMenuPadre"));
			menu.setDescripcion(rs.getString("Menu"));
			menu.setUrl(rs.getString("Controller"));
			return menu;
		}
	}
}
