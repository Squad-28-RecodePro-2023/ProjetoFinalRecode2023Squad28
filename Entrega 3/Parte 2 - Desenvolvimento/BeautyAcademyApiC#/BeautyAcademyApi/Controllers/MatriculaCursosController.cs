using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using BeautyAcademyApi.Context;
using BeautyAcademyApi.Models;

namespace BeautyAcademyApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MatriculaCursosController : ControllerBase
    {
        private readonly ApiDbContext _context;

        public MatriculaCursosController(ApiDbContext context)
        {
            _context = context;
        }

        // GET: api/MatriculaCursos
        [HttpGet]
        public async Task<ActionResult<IEnumerable<MatriculaCurso>>> GetMatriculaCursos()
        {
            return await _context.MatriculaCursos.ToListAsync();
        }

        // GET: api/MatriculaCursos/5
        [HttpGet("{id}")]
        public async Task<ActionResult<MatriculaCurso>> GetMatriculaCurso(int id)
        {
            var matriculaCurso = await _context.MatriculaCursos.FindAsync(id);

            if (matriculaCurso == null)
            {
                return NotFound();
            }

            return matriculaCurso;
        }

        // PUT: api/MatriculaCursos/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutMatriculaCurso(int id, MatriculaCurso matriculaCurso)
        {
            if (id != matriculaCurso.IdMatriculaCurso)
            {
                return BadRequest();
            }

            _context.Entry(matriculaCurso).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!MatriculaCursoExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/MatriculaCursos
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<MatriculaCurso>> PostMatriculaCurso(MatriculaCurso matriculaCurso)
        {
            _context.MatriculaCursos.Add(matriculaCurso);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetMatriculaCurso", new { id = matriculaCurso.IdMatriculaCurso }, matriculaCurso);
        }

        // DELETE: api/MatriculaCursos/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteMatriculaCurso(int id)
        {
            var matriculaCurso = await _context.MatriculaCursos.FindAsync(id);
            if (matriculaCurso == null)
            {
                return NotFound();
            }

            _context.MatriculaCursos.Remove(matriculaCurso);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool MatriculaCursoExists(int id)
        {
            return _context.MatriculaCursos.Any(e => e.IdMatriculaCurso == id);
        }
    }
}
