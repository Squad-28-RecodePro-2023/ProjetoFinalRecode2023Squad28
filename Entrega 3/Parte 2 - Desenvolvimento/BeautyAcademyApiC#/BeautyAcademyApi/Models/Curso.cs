using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace BeautyAcademyApi.Models
{
    [Table("Cursos")]
    public class Curso
    {
        public Curso()
        {
            MatriculaCursos = new Collection<MatriculaCurso>();
        }

        [Key]
        public int IdCurso { get; set; }

        [Required]
        [StringLength(80)]
        public string Nome { get; set; }

        [JsonIgnore]
        public ICollection<MatriculaCurso> MatriculaCursos { get; set; }
    }
}
