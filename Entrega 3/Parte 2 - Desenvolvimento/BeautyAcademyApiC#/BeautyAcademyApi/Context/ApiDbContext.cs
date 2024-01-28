using BeautyAcademyApi.Models;
using Microsoft.EntityFrameworkCore;

namespace BeautyAcademyApi.Context
{
    public class ApiDbContext: DbContext
    {
        public ApiDbContext(DbContextOptions<ApiDbContext>options) : base(options)
        {}

        public DbSet<Aluno> Categorias { get; set; }
        public DbSet<Cargo> Cargos { get; set; }
        public DbSet<Curso> Cursos { get; set; }
        public DbSet<MatriculaCurso> MatriculaCursos { get; set; }

    }
}
